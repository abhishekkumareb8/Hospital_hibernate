package ProjectContraller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projectDAO.BranchDAO;
import projectDAO.EncounterDAO;
import projectDAO.HospitalDAO;
import projectDAO.PersonDAO;
import projectDTO.Address;
import projectDTO.Branch;
import projectDTO.Encounter;
import projectDTO.Hospital;
import projectDTO.Items;
import projectDTO.MedOrder;
import projectDTO.Person;

public class HospitalContraller {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalDAO dao = new HospitalDAO();
		Hospital hospital = new Hospital();
		BranchDAO branchdao = new BranchDAO();
		Person person = new Person();
		PersonDAO personDao = new PersonDAO();
		System.out.println("Enter the Choice 1----Hospital,2-----Person");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter the hospital name");
			hospital.setName(sc.next());
			boolean a = true;
			List<Branch> listB = new ArrayList<Branch>();
			while (a) {
				System.out.println("Press 1-create branch,2-Noooooo");
				switch (sc.nextInt()) {
				case 1:
					Branch branches = new Branch();
					Address address = new Address();
					System.out.println("Enter the branch name");
					branches.setName(sc.next());
					System.out.println("Enter the Phone");
					branches.setPhone(sc.nextLong());

					System.out.println("Enter the location");
					address.setLocation(sc.next());
//					address.setBranches(branches);
					branches.setAddress(address);
					listB.add(branches);
					break;
				default:
					a = false;
					break;
				}
			}
			hospital.setBranchs(listB);
			dao.saveDetail(hospital);
			System.out.println("Saved");
			break;
		case 2:
			System.out.println("Enter the person name");
			person.setName(sc.next());
			System.out.println("Enter the phone");
			person.setPhone(sc.nextLong());
			List<Encounter> listE = new ArrayList<Encounter>();
			List<MedOrder> listM = new ArrayList<MedOrder>();
			List<Items> listT = new ArrayList<Items>();
			boolean b = true;
			while (b) {
				System.out.println("1---Encounter,2---Noooooo");
				switch (sc.nextInt()) {
				case 1:
					Encounter encounter = new Encounter();
					System.out.println("Enter the Reason");
					encounter.setReason(sc.next());
					encounter.setBranchs(branchdao.getDetails());
					boolean c = true;
					while (c) {
						System.out.println("1---create medorder,2---Nooooo");
						switch (sc.nextInt()) {
						case 1:
							MedOrder medorder = new MedOrder();
							System.out.println("Enter The details");
							medorder.setName(sc.next());
							boolean d = true;
							while (d) {
								System.out.println("1--To add tablets,2---Nooooo");
								switch (sc.nextInt()) {
								case 1:
									Items tablets = new Items();
									System.out.println("Enter the name");
									tablets.setName(sc.next());
									System.out.println("Enter the quantity");
									tablets.setQuantity(sc.nextInt());
									System.out.println("Enter the price");
									tablets.setPrice(sc.nextInt());
									listT.add(tablets);
									break;

								default:
									d = false;
									break;
								}
							}
							medorder.setItems(listT);
							listM.add(medorder);
							break;
						default:
							c = false;
							break;
						}
					}
					encounter.setMedOrders(listM);
					listE.add(encounter);
					break;

				default:b=false;
					break;
				}

			}
			person.setEncounters(listE);
			personDao.saveDetail(person);
			System.out.println("saved");
			break;
			
		}
	}
}