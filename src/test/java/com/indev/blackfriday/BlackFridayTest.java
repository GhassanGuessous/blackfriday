package com.indev.blackfriday;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
    This test is about a company that is selling products (here capsules and machines) in black friday
    The company have a stock of products
    The company can sell a given product at a fixed quantity and have a price sale margin of 20%
    In black friday, the company is selling two times the usual quantity (10 instead of 5) but have only a price sale margin of 10%
 */
public class BlackFridayTest {

    /*
        Total assets is the total of money owned by the company
     */
    @Test
    public void oneProductInStock() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        assertThat(company.totalAssets(), is(20));
    }

    @Test
    public void twoProductsInStock() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        assertThat(company.totalAssets(), is(520));
    }

    /*
        The company can sell a given product at a fixed quantity of 5, the price margin of each sale is 20%
     */
    @Test
    public void sellsProduct() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        float salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));
        assertThat(company.totalAssets(), is(22));
    }

    @Test
    public void sellsProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        float salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));
        salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));
        assertThat(company.totalAssets(), is(24));
    }

    @Test
    public void sellsDifferentProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));
        salePrice = company.sells("machine");
        assertThat(salePrice, is(600f));
        assertThat(company.totalAssets(), is(622));
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void sellsMoreThanStock() {
        Company company = new Company();
        company.stock(5, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));
        company.sells("capsule");
    }

    /*
        In Black friday the sells are 2 times higher, but the price margin is only 10%
     */
    @Ignore
    @Test
    public void blackFridaySellProduct() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.blackFriday().sells("capsule");
        assertThat(salePrice, is(22f));
        assertThat(company.totalAssets(), is(522));
    }

    @Ignore
    @Test
    public void blackFridaySellProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(10, "machine", 100);
        float salePrice = company.blackFriday().sells("capsule");
        assertThat(salePrice, is(22f));
        salePrice = company.blackFriday().sells("machine");
        assertThat(salePrice, is(1100f));
        assertThat(company.totalAssets(), is(1122));
    }

    @Test
    public void sellsWithProxy() {
        Company company = new Company();
        company.stock(10, "capsule", 2);

        assertThat(company.salesHistory(), CoreMatchers.<Object>equalTo(""));

        float salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));

        assertThat(company.salesHistory(), CoreMatchers.<Object>equalTo("5:capsules"));

        salePrice = company.sells("capsule");
        assertThat(salePrice, is(12f));

        assertThat(company.salesHistory(), CoreMatchers.<Object>equalTo("10:capsules"));

        assertThat(company.totalAssets(), is(24));
    }
}
