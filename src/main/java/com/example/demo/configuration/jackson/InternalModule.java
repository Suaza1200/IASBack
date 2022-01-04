package com.example.demo.configuration.jackson;

import com.example.demo.configuration.jackson.codecs.*;
import com.example.demo.domain.*;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class InternalModule extends SimpleModule {

    private static final String NAME = "InternalModule";

    public InternalModule() {
        super(NAME, Version.unknownVersion());

        addSerializer(ProductQuantity.class, new ProductQuantityCodecs.Serializer());
        addDeserializer(ProductQuantity.class, new ProductQuantityCodecs.Deserializer());



        addSerializer(ProductId.class, new ProductIdParser.Serializer());
        addDeserializer(ProductId.class, new ProductIdParser.Deserializer());

        addSerializer(ProductName.class, new ProductNameParser.Serializer());
        addDeserializer(ProductName.class, new ProductNameParser.Deserializer());

        addSerializer(ProductPrice.class, new ProductPriceParser.Serializer());
        addDeserializer(ProductPrice.class, new ProductPriceParser.Deserializer());

        addSerializer(ProductDescription.class, new ProductDescriptionParser.Serializer());
        addDeserializer(ProductDescription.class, new ProductDescriptionParser.Deserializer());


    }
}
