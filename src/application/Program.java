package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			
			SellerDao sellerDao = DaoFactory.createSellerDao();//instancia interface fabrica de DAO
			
			System.out.println("==== TESTE 1: seller findById =====");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			
			System.out.println("\n===  TESTE 2: seller findByDepartment ==== ");
			Department department = new Department(2, null);
			List<Seller> list = sellerDao.findByDepartment(department);
	
			for (Seller obj : list){
				System.out.println(obj);
			}
			
			System.out.println("\n===  TESTE 3: seller findByAll ==== ");
			list = sellerDao.findAll();
	
			for (Seller obj : list){
				System.out.println(obj);
			}
	
			System.out.println("\n===  TESTE 4: seller insert ==== ");
			Seller newSeller = new Seller(null, "Greg", "greg@gmail",new Date(), 4000.00, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserido! New id = "+ newSeller.getId());
			

			System.out.println("\n===  TESTE 5: seller Update ==== ");
			seller = sellerDao.findById(1);
			seller.setName("Martha Waine");
			sellerDao.update(seller);
			System.out.println("Update Completo!");
	
	
			System.out.println("\n===  TESTE 6: seller Delete ==== ");
			System.out.println("Entre com o id:");
			int id = sc.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Delete completo");
			
			sc.close();
			
	}

}
