case class StockLevel(stock: Map[MenuItem, Int]) {
  def updateStock(item: MenuItem, newCount: Int): StockLevel =
    copy(stock = stock.updated(item, newCount))

  def getStockCount(item: MenuItem): Int =
    stock.getOrElse(item, 0)
}
