package Builder.UserBuilder;

public class User {
    String name;
    int age;
    String email;
    int phoneNo;

    // private user constructor to restrict direct object instantiation.
    private User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }

    static class UserBuilder{

        private User user = new User();

        public UserBuilder setName(String name){
            user.name = name;
            return this;
        }

        public UserBuilder setAge(int age){
            user.age = age;
            return this;
        }

        public UserBuilder setEmail(String email){
            user.email = email;
            return this;
        }

        public UserBuilder setPhoneNo(int phoneNo){
            user.phoneNo = phoneNo;
            return this;
        }

        public User build(){
            return user;
        }

    }

    static void main(){
        User user1 = new  User.UserBuilder()
                .setName("user1")
                .setAge(21)
                .setPhoneNo(12345)
                .build();
        System.out.println(user1);

        User user2 = new  User.UserBuilder()
                .setName("user2")
                .setAge(21)
                .build();
        System.out.println(user2);


    }


}
