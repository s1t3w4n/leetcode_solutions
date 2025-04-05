import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class GroupUserByDataStream {
    /**
     * Необходимо сгруппировать данные массива List<User> по датам регистрации пользователя (registrationDate)
     * 1) пользователи, зарегистрированные в одинаковое время должны быть помещены в List<User>
     * 2) Итоговый результат: структура данных - Map<LocalDateTime, List<User>>
     */
    public static void main(String[] args) {
        var users = List.of(
                new User("jerry-Smith_43", "Jerry", "Smith", LocalDateTime.of(2020, 7, 23, 17, 30),
                        List.of(new Role("USER", List.of("READ", "CREATE", "UPDATE")))),
                new User("rick-sunches-the-best-15", "Rick", "Sunches", LocalDateTime.of(2020, 7, 23, 17, 30),
                        List.of(new Role("ADMIN", List.of("READ", "CREATE", "UPDATE", "DELETE")))),
                new User("mortyEvil", "Morty", "Smith Evil", LocalDateTime.of(2021, 8, 17, 20, 30),
                        List.of(new Role("ADMIN", List.of("READ", "CREATE", "UPDATE", "DELETE")))));
        Map<LocalDateTime, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getRegistrationDate));
        System.out.println(collect);
    }


    public static class User {

        private final String username;

        private final String firstName;

        private final String lastName;

        private final LocalDateTime registrationDate;

        private final List<Role> roles;

        public User(String username, String firstName, String lastName, LocalDateTime registrationDate, List<Role> roles) {
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.registrationDate = registrationDate;
            this.roles = roles;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDateTime getRegistrationDate() {
            return registrationDate;
        }

        public List<Role> getRoles() {
            return roles;
        }
    }

    public static class Role {

        private final String roleName;

        private final List<String> privileges;

        public Role(String roleName, List<String> privileges) {
            this.roleName = roleName;
            this.privileges = privileges;
        }

        public String getRoleName() {
            return roleName;
        }

        public List<String> getPrivileges() {
            return privileges;
        }
    }
}