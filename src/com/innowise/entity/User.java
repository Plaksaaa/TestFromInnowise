package com.innowise.entity;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Role firstRole;
    private Role secondRole;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String thirdPhoneNumber;

    private User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Role getFirstRole() {
        return firstRole;
    }

    public Role getSecondRole() {
        return secondRole;
    }

    public String getFirstPhoneNumber() {
        return firstPhoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public String getThirdPhoneNumber() {
        return thirdPhoneNumber;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;

            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;

            return this;
        }

        public Builder setFirstRole(Role firstRole) {
            User.this.firstRole = firstRole;

            return this;
        }

        public Builder setSecondRole(Role secondRole) {
            User.this.secondRole = secondRole;

            return this;
        }

        public Builder setFirstPhoneNumber(String firstPhoneNumber) {
            User.this.firstPhoneNumber = firstPhoneNumber;

            return this;
        }

        public Builder setSecondPhoneNumber(String secondPhoneNumber) {
            User.this.secondPhoneNumber = secondPhoneNumber;

            return this;
        }

        public Builder setThirdPhoneNumber(String thirdPhoneNumber) {
            User.this.thirdPhoneNumber = thirdPhoneNumber;

            return this;
        }

        public User build() {
            return User.this;
        }
    }

//    Так как email у всех разный могу не добавлять все в equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
               lastName.equals(user.lastName) &&
               email.equals(user.email) &&
               firstRole == user.firstRole &&
               firstPhoneNumber.equals(user.firstPhoneNumber) &&
               Objects.equals(secondPhoneNumber, user.secondPhoneNumber) &&
               Objects.equals(thirdPhoneNumber, user.thirdPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", role=" + firstRole +
               ", firstPhoneNumber='" + firstPhoneNumber + '\'' +
               ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
               ", thirdPhoneNumber='" + thirdPhoneNumber + '\'' +
               '}';
    }
}
