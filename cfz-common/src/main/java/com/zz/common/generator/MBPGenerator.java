package com.zz.common.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

public class MBPGenerator {
    public void generator(String packageName,String moduleName,Object superClass){
        DataSourceConfig.Builder builder = new DataSourceConfig.Builder("jdbc:mysql://localhost:6666/coffee_zz", "root", "Password123");

        FastAutoGenerator.create(builder)
                .globalConfig(globalConfig -> {
                    globalConfig.outputDir("C://Code/generator")
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir();
                })
                .strategyConfig(strategy -> {
                    strategy.addTablePrefix("tb_")
                            .addTableSuffix("_v1")
                            .entityBuilder()
                            .superClass(superClass.getClass())
                            .enableLombok()
//                            .enableColumnConstant()
                            .enableChainModel()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .formatFileName("%sEntity")
                            .addSuperEntityColumns("create_time","update_time","create_by","update_by")
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("create_by", FieldFill.INSERT))
                            .addTableFills(new Column("update_by", FieldFill.INSERT_UPDATE))
                            .idType(IdType.ASSIGN_ID)
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableMapperAnnotation();
                })
                .injectionConfig(injection -> {
                    injection.fileOverride();
                })
                .packageConfig(c -> {
                    c.parent("com.zz.auth");
                })


                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
