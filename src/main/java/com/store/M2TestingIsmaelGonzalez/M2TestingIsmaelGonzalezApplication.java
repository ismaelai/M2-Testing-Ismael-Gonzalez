package com.store.M2TestingIsmaelGonzalez;

import com.store.M2TestingIsmaelGonzalez.Entities.Employee;
import com.store.M2TestingIsmaelGonzalez.Repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@SpringBootApplication
public class M2TestingIsmaelGonzalezApplication implements CommandLineRunner {

  @Autowired
	employeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingIsmaelGonzalezApplication.class, args);
		System.out.println("App running");
	}
	public void showMenu() {
		System.out.println("1 - Crea un empleado");
		System.out.println("2 - Ver empleado por id");
		System.out.println("3 - Ver todos los empleados");
		System.out.println("4 - Ver empleado por nombre");
		System.out.println("5 - Borrar empleado por id");
		System.out.println("6 - Salir");
	}


	@Override
	public void run(String... args) throws Exception {


			while (true) {
				Scanner scanner = new Scanner(System.in);
				showMenu();
				try { // pedir una opción por consola
					int opcion = scanner.nextInt();
					scanner.nextLine();

					if (opcion == 1) { // Creando un empleado
						System.out.println("Introduce el nombre del empleado");
						String name = scanner.nextLine();

						System.out.println("Introduce el apellido");
						String lastName = scanner.nextLine();

						System.out.println("Introduce edad");
						Integer age = scanner.nextInt();

						System.out.println("Introduce año de comienzo");
						double dateStart = scanner.nextDouble();

						System.out.println("Introduce año de nacimiento");
						double birthDate = scanner.nextDouble();

						System.out.println("¿Esta casado? true o false");
						boolean married = scanner.nextBoolean();
						// Crea el objeto
						Employee empleado = new Employee
								(null,"ex1", "ex1", 33, LocalDate.of(1993, 4, 2),
										LocalDate.of(2007, 4 , 5), true );

						// Guarda el objeto
						employeeRepository.save(empleado);
						System.out.println("empleado creado");

					}else if (opcion == 2) {
						System.out.println("Introduzca el id de empleado");
						Long id = scanner.nextLong();
						Optional<Employee> employeeOpt = employeeRepository.findById(id);
						if (employeeOpt.isPresent()) {
							Employee employee = employeeOpt.get();
							System.out.println(employee);
						} else {
							System.out.println("No existe ese empleado");
						}

					}else if (opcion == 3) {
						List<Employee> employees = employeeRepository.findAll();
						if (employees.isEmpty()) {
							System.out.println("No hay empleados disponibles.");
						} else {
							System.out.println(employees);
						}

					} else if (opcion == 4) {

						System.out.println("Introduzca el nombre del empleado: ");
						String name = scanner.nextLine();
						List<Employee> employees = employeeRepository.findByFirstName(name);
						for (Employee employee : employees)
							System.out.println(employee);


					} else if (opcion == 5) {
						System.out.println("Introduzca el id de empleado");
						Long id = scanner.nextLong();
						boolean exists = employeeRepository.existsById(id);

						if (exists) {
							employeeRepository.deleteById(id);
							System.out.println("empleado borrado");
						} else {
							System.out.println("No existe ese empleado");
						}

					} if (opcion == 6) {
						System.out.println("see you!");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	}
}
