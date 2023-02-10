package com.jin.blog.sunset.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Collections;

/**
 * @Description 主要生成controller层代码
 * @ClassName: Gen2
 * @author: jinzelei
 * @date: 2023/2/3 11:19
 **/
public class Gen2 {
    public static void main(String[] args){
        String projectPath = System.getProperty("user.dir"); //获取项目路径
        String filePath = projectPath + "/blog-sunset-base/src/main/java";  //java下的文件路径
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog_sunset?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
                "root","123456")
                .globalConfig(builder -> builder
                        .outputDir(filePath)//生成的输出路径
                        .author("jinzelei")//生成的作者名字
                        .enableSwagger()//开启swagger
                        .dateType(DateType.TIME_PACK)//时间策略
                        .commentDate("yyyy-MM-dd HH:mm:ss")//格式化时间格式
                        .disableOpenDir()//禁止打开输出目录，默认false
                        .fileOverride()//覆盖生成文件
                        .build())
                .strategyConfig(builder -> builder
                        .enableCapitalMode()//开启全局大写命名
                        //.enableCapitalMode().addInclude("t_person").addTablePrefix("t_")

                        .entityBuilder().idType(IdType.ASSIGN_UUID)
                        //.enableLombok().enableActiveRecord().fileOverride()
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .versionColumnName("version").versionPropertyName("version")
                        .formatFileName("%s")

                        .mapperBuilder()
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        //.fileOverride()

                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")

                        .controllerBuilder().enableRestStyle().formatFileName("%sController")
                        .controllerBuilder()//控制层策略
                        //.enableHyphenStyle()开启驼峰转连字符，默认：false
                        .enableRestStyle()//开启生成@RestController
                        .formatFileName("%sController")//格式化文件名称
                        .build())
                .packageConfig(builder -> builder
                        .parent("com.jin.blog.sunset")
                        //.entity("pojo")
                        // .mapper("dao")
                        //.service("service")
                        //.serviceImpl("service.impl")
                        .controller("controller")
                        //.pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mappers/"))
                        //设置mapper文件的自定义路径
                        .build())
                .templateConfig(builder -> builder.controller("/template/controller.java.vm"))
                //使用自定义的实体类模板生成类
                .execute();

    }
}
