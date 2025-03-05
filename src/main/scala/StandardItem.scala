


case class StandardItem(name: String, price: BigDecimal, itemCategory: ItemCategory) extends MenuItem

object StandardItem {
  val coffee = StandardItem("Coffee", 3.25, HotDrink)
  val tea = StandardItem("Tea", 2.50, HotDrink)
  val icedCoffee = StandardItem("Iced Coffee", 3.25, ColdDrink)
  val icedTea = StandardItem("Iced Tea", 2.95, ColdDrink)
  val fruitJuice = StandardItem("Fruit Juice", 2.95, ColdDrink)
  val sandwich = StandardItem("Sandwich", 5.95, ColdFood)
  val cake = StandardItem("Cake", 4.95, ColdFood)
  val soup = StandardItem("Soup", 7.95, HotFood)
  val Toastie = StandardItem("Toastie", 7.95, HotFood)
}