import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StockLevelSpec extends AnyWordSpec with Matchers {
  val coffee: PremiumSpecial = PremiumSpecial("Luxury Coffee", 5.00)
  val burger: PremiumSpecial = PremiumSpecial("Wagyu Burger", 15.00)
  val pasta: PremiumSpecial = PremiumSpecial("Truffle Pasta", 25.00)
  val stock: StockLevel = StockLevel(Map(coffee -> 10, burger -> 5))

  "return correct stock count" in {
    stock.getStockCount(coffee) shouldBe 10
    stock.getStockCount(burger) shouldBe 5
    stock.getStockCount(pasta) shouldBe 0 // Not in stock
  }

  "update stock count" in {
    val updatedStock = stock.updateStock(coffee, 8)
    updatedStock.getStockCount(coffee) shouldBe 8
    updatedStock.getStockCount(burger) shouldBe 5
  }


}
