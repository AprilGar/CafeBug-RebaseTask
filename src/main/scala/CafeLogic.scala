import scala.math.BigDecimal.RoundingMode

class CafeLogic {

  //Place an order
  def placeOrder(stock: StockLevel, order: Order): Either[String, StockLevel] = {
    val insufficientStock = order.items.find(item => stock.getStockCount(item) == 0)
    insufficientStock match {
      case Some(outOfStockItem) => Left(s"Item '${outOfStockItem.name}' is out of stock.")
      case None =>
        val updatedStock = order.items.foldLeft(stock) { (currentStock, item) =>
          currentStock.updateStock(item, currentStock.getStockCount(item) - 1)
        }
        Right(updatedStock)
    }
  }

  //Calculate item total
  def getItemTotal(order: Order): BigDecimal = {
    order.items.map(_.price).sum
  }

  //Service Charge
  def calculateServiceCharge(order: Order): BigDecimal = {
    val calcPercentageCharge = if (order.items.exists(item => item.itemCategory == PremiumMeal)) 0.25
    else if (order.items.exists(item => item.itemCategory == HotFood)) 0.20
    else if (order.items.exists(item => item.itemCategory == ColdFood)) 0.10
    else 0.0
    (getItemTotal(order) * calcPercentageCharge).setScale(2, RoundingMode.HALF_UP)
  }

  //Generate bill
  def generateBill(order: Order, customer: Customer): BigDecimal = {
    val additionalServiceCharge = order.customServiceCharge.getOrElse(calculateServiceCharge(order))
    val discount = applyDiscount(customer, getItemTotal(order))
    ((getItemTotal(order) - discount) + additionalServiceCharge).setScale(2, RoundingMode.HALF_UP)
  }

  //Apply discount
  def applyDiscount(customer: Customer, baseTotal: BigDecimal): BigDecimal = {
    customer.loyaltyCard match {
      case Some(DiscountLoyaltyCard(stars)) if baseTotal > 20 => baseTotal * (stars * 0.02).min(0.16)
      case _ => 0
    }
  }


}
