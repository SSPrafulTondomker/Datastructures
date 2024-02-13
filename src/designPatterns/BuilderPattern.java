package designPatterns;


class Employee {
    String name;
    String role;
    Boolean hasBike;
    Boolean hasCar;
    Employee(EmployeeBuilder employeeBuilder) {
        this.hasBike = employeeBuilder.hasBike;
        this.name = employeeBuilder.name;
        this.role = employeeBuilder.role;
        this.hasCar = employeeBuilder.hasCar;
    }

    public static class EmployeeBuilder {
        String name;
        String role;
        Boolean hasBike;
        Boolean hasCar;

        public Employee build() {
            return new Employee(this);
        }

        public EmployeeBuilder setHasBike(Boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }

        public EmployeeBuilder setHasCar(Boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setRole(String role) {
            this.role = role;
            return this;
        }

    }
}



public class BuilderPattern {
    public static void main (String[] args) {
        Employee employee = new Employee.EmployeeBuilder().setHasBike(false).setHasBike(true).build();
    }
}
