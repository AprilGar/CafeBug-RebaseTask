trait MenuItem {
  def name: String

  def price: BigDecimal

  def itemCategory: ItemCategory
}

sealed trait ItemCategory

case object HotDrink extends ItemCategory

case object ColdDrink extends ItemCategory

case object HotFood extends ItemCategory

case object ColdFood extends ItemCategory

case object PremiumMeal extends ItemCategory

case object Sand extends ItemCategory

case object PastryItem extends ItemCategory

case object SeaFood extends ItemCategory

case object SideOrder extends ItemCategory