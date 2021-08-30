package com.innowise.entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Map<Integer, Role> roles;
    private List<String> phoneList;

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

    public Map<Integer, Role> getRoles() {
        return roles;
    }

    public List<String> getPhoneList() {
        return phoneList;
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

        public Builder setRoleMap(Map<Integer, Role> roles) {
            User.this.roles = roles;

            return this;
        }

        public Builder setPhoneList(List<String> phoneList) {
            User.this.phoneList = phoneList;

            return this;
        }

        public User build() {
            return User.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
               lastName.equals(user.lastName) &&
               email.equals(user.email) &&
               roles.equals(user.roles) &&
               phoneList.equals(user.phoneList);
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
               ", roles=" + roles +
               ", phoneList=" + phoneList +
               '}';
    }
}
