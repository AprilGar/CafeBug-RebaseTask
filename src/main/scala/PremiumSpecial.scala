case class PremiumSpecial(name: String, price: BigDecimal) extends MenuItem {
  def itemCategory: ItemCategory = PremiumMeal
}
object PremiumSpecial {
  val specialDrink = PremiumSpecial("Special Drink", 4.25)
  val specialFood = PremiumSpecial("Special Food", 8.75)
}