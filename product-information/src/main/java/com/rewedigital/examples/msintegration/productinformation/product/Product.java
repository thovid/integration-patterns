package com.rewedigital.examples.msintegration.productinformation.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rewedigital.examples.msintegration.productinformation.infrastructure.eventing.EventPublishingEntityListener;
import com.rewedigital.examples.msintegration.productinformation.infrastructure.eventing.EventSource;

@Entity
@EntityListeners(EventPublishingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements EventSource {

    @Id
    private String id;
    private String name;
    private String vendor;
    private String price;

    @Column(length = 2000)
    private String description;

    @NotNull
    private String productNumber;
    private String image;

    @Version
    private Long version;

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setVendor(final String vendor) {
        this.vendor = vendor;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setProductNumber(final String productNumber) {
        this.productNumber = productNumber;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String getAggregateName() {
        return "product";
    }
}
