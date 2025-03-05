import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LoyaltyCardLogicSpec extends AnyWordSpec with Matchers {

  val loyaltyCardLogic = new LoyaltyCardLogic

  "LoyaltyScheme" should {
    "deny loyalty card application if under 18" in {
      val customer = Customer("Alice", age = 17, visits = 6, totalSpend = 200)
      loyaltyCardLogic.applyForCard(customer, DiscountLoyaltyCard()) shouldBe Left("Not eligible for a loyalty card.")
    }
    "grant discount card if criteria met" in {
      val customer = Customer("Bob", age = 20, visits = 6, totalSpend = 200)
      loyaltyCardLogic.applyForCard(customer, DiscountLoyaltyCard()) shouldBe Right(customer.copy(loyaltyCard = Some(DiscountLoyaltyCard())))
    }
  }

}
