package com.ttmdear.repository.springmvc.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping(value = "", consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public String indexActionForForm(UserInput userInput) {
        return indexAction(userInput);
    }

    @PostMapping("")
    @ResponseBody
    public String indexAction(@RequestBody UserInput userInput) {
        return userInput.toString();
    }

    /**
     * DTO dla danych z formularza.
     */
    public static class UserInput {
        public String id;
        public UserEmailInput[] email;
        public UserPaymentInput payment;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public UserEmailInput[] getEmail() {
            return email;
        }

        public void setEmail(UserEmailInput[] email) {
            this.email = email;
        }

        public UserPaymentInput getPayment() {
            return payment;
        }

        public void setPayment(UserPaymentInput payment) {
            this.payment = payment;
        }

        @Override
        public String toString() {
            return "UserInput{" +
                    "id='" + id + '\'' +
                    ", email=" + Arrays.toString(email) +
                    ", payment=" + payment +
                    '}';
        }
    }

    public static class UserEmailInput {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "UserEmailInput{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public static class UserPaymentInput {
        private String type;
        private float rate;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "UserPaymentInput{" +
                    "type='" + type + '\'' +
                    ", rate=" + rate +
                    '}';
        }
    }
}
