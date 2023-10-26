package kitchenpos.menu.domain;

import kitchenpos.BaseTest;
import kitchenpos.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

class MenuProductTest extends BaseTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 10, 10000", "10, 1, 10", "5, 5, 25", "1, 1, 1"})
    void 메뉴_상품의_가격의_총합을_구한다(BigDecimal productPrice, Long quantity, BigDecimal expected) {
        // given
        Product product = new Product("chicken", productPrice);
        MenuProductQuantity menuProductQuantity = new MenuProductQuantity(quantity);

        MenuProduct menuProduct = new MenuProduct(product, menuProductQuantity);

        // when
        BigDecimal actual = menuProduct.calculateTotalPrice();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}