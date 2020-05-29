package com.manifesting.fileConvertor.tcda.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TCDA")
public class TcdaModel {

        @Id
        String trackingId;

        String marketPlaceID;
        String scheduledDeliveryDate;
        String estimatedArrivalDate;
        String length;
        String height;
        String width;
        String name;
        String city;
        String zip;
        String countryCode;
        String countryName;
        String contactPhone;

        public TcdaModel(){

        }
        public TcdaModel ( String trackingId , String marketPlaceID , String scheduledDeliveryDate , String estimatedArrivalDate , String length , String height , String width , String name , String city , String zip , String countryCode , String countryName , String contactPhone ) {

            this.trackingId = trackingId;
            this.marketPlaceID = marketPlaceID;
            this.scheduledDeliveryDate = scheduledDeliveryDate;
            this.estimatedArrivalDate = estimatedArrivalDate;
            this.length = length;
            this.height = height;
            this.width = width;
            this.name = name;
            this.city = city;
            this.zip = zip;
            this.countryCode = countryCode;
            this.countryName = countryName;
            this.contactPhone = contactPhone;
        }

        public String getTrackingId () {
            return trackingId;
        }

        public void setTrackingId ( String trackingId ) {
            this.trackingId = trackingId;
        }

        public String getMarketPlaceID () {
            return marketPlaceID;
        }

        public void setMarketPlaceID ( String marketPlaceID ) {
            this.marketPlaceID = marketPlaceID;
        }

        public String getScheduledDeliveryDate () {
            return scheduledDeliveryDate;
        }

        public void setScheduledDeliveryDate ( String scheduledDeliveryDate ) {
            this.scheduledDeliveryDate = scheduledDeliveryDate;
        }

        public String getEstimatedArrivalDate () {
            return estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate ( String estimatedArrivalDate ) {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        public String getLength () {
            return length;
        }

        public void setLength ( String length ) {
            this.length = length;
        }

        public String getHeight () {
            return height;
        }

        public void setHeight ( String height ) {
            this.height = height;
        }

        public String getWidth () {
            return width;
        }

        public void setWidth ( String width ) {
            this.width = width;
        }

        public String getName () {
            return name;
        }

        public void setName ( String name ) {
            this.name = name;
        }

        public String getCity () {
            return city;
        }

        public void setCity ( String city ) {
            this.city = city;
        }

        public String getZip () {
            return zip;
        }

        public void setZip ( String zip ) {
            this.zip = zip;
        }

        public String getCountryCode () {
            return countryCode;
        }

        public void setCountryCode ( String countryCode ) {
            this.countryCode = countryCode;
        }

        public String getCountryName () {
            return countryName;
        }

        public void setCountryName ( String countryName ) {
            this.countryName = countryName;
        }

        public String getContactPhone () {
            return contactPhone;
        }

        public void setContactPhone ( String contactPhone ) {
            this.contactPhone = contactPhone;
        }



}
