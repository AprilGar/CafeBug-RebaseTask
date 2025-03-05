import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MenuSpec  extends AnyWordSpec with Matchers {
  val coffee = PremiumSpecial("Luxury Coffee", 5.00)
  val burger = PremiumSpecial("Wagyu Burger", 15.00)
  val pasta = PremiumSpecial("Truffle Pasta", 25.00)

  "add a premium special" in {
    val menu = Menu(List(coffee, burger))
    val updatedMenu = menu.addPremiumSpecial(pasta)

    updatedMenu.menuItem should contain(pasta)
//    updatedMenu.menuItem should have size 3
    updatedMenu.menuItem.length shouldBe 3
  }

  "remove a premium special" in {
    val menu = Menu(List(coffee, burger, pasta))
    val updatedMenu = menu.removePremiumSpecial("Truffle Pasta")

    updatedMenu.menuItem should not contain pasta
    updatedMenu.menuItem should have size 2
  }

}
