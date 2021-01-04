package com.amazon.springapi.config;

import com.amazon.springapi.entity.home.Category;
import com.amazon.springapi.repository.home.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableMongoRepositories(basePackageClasses = {
        CategoryRepository.class
})
@Configuration
public class MongoDBConfig {

    //  ApplicationRunner
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository) {

        return strings -> {
//            (add(""),add(")
            ArrayList<String> homeCategoryUrls = new ArrayList(
                    Arrays.asList(
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/July/amazonbasics_520x520._SY304_CB442725065_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/amazonglobal/images/email/asins/DURM-2307572AF7CDC91G._V535755378_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Electronics_1x._SY304_CB432774322_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Events/2020/PrimeDay/Fuji_Dash_PD_Nonprime__1x._SY304_CB403084762_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_PC_1x._SY304_CB431800965_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Beauty_1x._SY304_CB432774351_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Deals_1x._SY304_CB430401028_.jpg"
                    )
            );

            String[] titles = {
                    "AmazonBasics",
                    "Shop by Category",
                    "Electronics",
                    "Shop top categories",
                    "Computers & Accessories",
                    "Beauty picks",
                    "Deals & Promotions"
            };

            List categories = new ArrayList();
            categories = IntStream
                    .range(0, homeCategoryUrls.size())
                    .mapToObj(i -> {
                        return new Category(i, titles[i], homeCategoryUrls.get(i), i == 0 || i == 1 || i == 2);
                    })
                    .collect(Collectors.toList());

            categoryRepository.saveAll(categories);

        };
    }
}
