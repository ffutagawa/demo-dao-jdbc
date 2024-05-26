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
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1 seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2 seller findByDepartmen ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3 seller findByDepartmen ====");	
		list = sellerDao.findAll();
		for(Seller obj : list) {
		System.out.println(obj);	
		}
		
		System.out.println("\n==== TEST 4 seller SellerInsert ====");
		Seller newSeller = new Seller(null, "Amanda Mendes", "amandamendesg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido novo ID: " + newSeller.getId());
		
		System.out.println("\n==== TEST 5 seller SellerUpdate====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Atualização feita com sucesso");
		
		System.out.println("\n==== TEST 6 seller SellerDelete====");
		System.out.print("Informe um id a ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletado com sucesso");
	}

}
