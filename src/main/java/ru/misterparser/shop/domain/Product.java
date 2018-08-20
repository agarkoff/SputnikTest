package ru.misterparser.shop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "sku")
public class Product {

    private String sku;
    private BigDecimal price;
    private Category category;
    private Size size;
    private Color color;
    private String description;
    private Exists exists;

    public enum Category {
        DRESS("платье"),
        PANTS("брюки"),
        SKIRT("юбка"),
        VEST("жилетка"),
        SHIRT("рубашка");

        Category(String category) {
            this.category = category;
        }

        private String category;

        @Override
        public String toString() {
            return category;
        }
    }

    public enum Size {
        SIZE_42(42),
        SIZE_44(44),
        SIZE_46(46),
        SIZE_48(48),
        SIZE_50(50),
        SIZE_52(52),
        SIZE_54(54);

        Size(int size) {
            this.size = size;
        }

        private int size;

        @Override
        public String toString() {
            return String.valueOf(size);
        }
    }

    public enum Color {
        WHITE("белый"),
        BLUE("синий"),
        RED("красный"),
        GREEN("зелёный"),
        BLACK("чёрный");

        Color(String color) {
            this.color = color;
        }

        private String color;

        @Override
        public String toString() {
            return color;
        }
    }

    public enum Exists {
        SHOP("магазин"),
        WAREHOUSE("склад");

        Exists(String title) {
            this.title = title;
        }

        private String title;

        @Override
        public String toString() {
            return title;
        }
    }
}
