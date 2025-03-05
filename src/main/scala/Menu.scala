case class Menu(menuItem: List[MenuItem]) {
  def addPremiumSpecial(special: PremiumSpecial): Menu = {
    copy(menuItem = menuItem :+ special)
  }

  def removePremiumSpecial(specialName: String): Menu =
    copy(menuItem = menuItem.filterNot(item => item.name == specialName))
}
