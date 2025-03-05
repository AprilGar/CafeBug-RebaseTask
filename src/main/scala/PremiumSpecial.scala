case class PremiumSpecial(name: String, price: BigDecimal) extends MenuItem {
  def itemCategory: ItemCategory = PremiumMeal
}
