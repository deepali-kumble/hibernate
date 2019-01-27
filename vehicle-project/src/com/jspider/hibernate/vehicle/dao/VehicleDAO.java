package com.jspider.hibernate.vehicle.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jspider.hibernate.vehicle.dto.VehicleDTO;
import com.jspider.hibernate.vehicle.util.HibernateUtil;

public class VehicleDAO 
{
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public Integer saveVehicle(VehicleDTO dto) 
	{
		Session session = null;
		Transaction transaction = null;
		Integer identifier = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			identifier = (Integer) session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		if (session != null) {
			session.close();

		}
		return identifier;

	}
	public int updatePriceByNameAndMileage(String vehicleName,double mileage,double price) 
	{
		int noOfRecordsUpdated = 0;
		Transaction tx = null;
		String hql="UPDATE VehicleDTO vehicle SET vehicle.price=:vprice WHERE vehicle.vehicleName=:vname AND vehicle.mileage=:vmileage ";
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("vprice", price);
			query.setParameter("vname", vehicleName);
			query.setParameter("vmileage", mileage);
			noOfRecordsUpdated = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		return noOfRecordsUpdated;
	}
	//ERROR
	/*
	public String getVehicleNameByMileageGreaterThan(double mileage)
	{
		String vehicleName=null;
		String hql="SELECT vehicleName FROM VehicleDTO vehicle WHERE (vehicle.mileage)>:vmileage ";
		try(Session session=factory.openSession()) {
			Query query = session.createQuery(hql);
			query.setParameter("vmileage", mileage);
			vehicleName=(String) query.setMaxResults(3).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vehicleName;
	}
	*/
	
	
	public String getVehicleByTopSpeed(int topSpeed) {
		String vehicleName=null;
		String hql="SELECT vehicle.vehicleName FROM VehicleDTO vehicle WHERE vehicle.topSpeed=:vtopspeed ";
		try(Session session=factory.openSession()) {
			
			Query query=session.createQuery(hql);
			query.setParameter("vtopspeed", topSpeed);
		vehicleName= (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vehicleName;
	}
	
	public int UpdateTopSpeedByVehicleName(int topSpeed,String vehicleName) 
	{
		int noOfRecordsUpdated=0;
		Transaction tx=null;
		String hql="UPDATE VehicleDTO vehicle SET vehicle.topSpeed=:tspeed WHERE vehicle.vehicleName=:vname";
		try (Session session=factory.openSession()){
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("tspeed", topSpeed);
			query.setParameter("vname",vehicleName);
			 noOfRecordsUpdated=query.executeUpdate();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return noOfRecordsUpdated;

	}
	public List<VehicleDTO> getMinMileage() 
	{
		List<VehicleDTO> mileage=null;
		String hql="SELECT min(vehicle.mileage)"
				+ " FROM VehicleDTO vehicle ";
		try (Session session=factory.openSession()){
			Query query=session.createQuery(hql);
			mileage=query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}	
		return mileage;

	}
	
	public List<VehicleDTO> getMaxTopSpeed() 
	{
		List<VehicleDTO>topSpeed=null;
		String hql=" SELECT max(vehicle.topSpeed)"
				+ "FROM VehicleDTO vehicle";
		
		try (Session session=factory.openSession()){
			Query query=session.createQuery(hql);
			topSpeed=query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}	
		return topSpeed;

	}
	
	public List<VehicleDTO> getVehicleCount() 
	{
		List<VehicleDTO>topSpeed=null;
		String hql=" SELECT count(vehicle.topSpeed)"
				+ "FROM VehicleDTO vehicle";
		
		try (Session session=factory.openSession()){
			Query query=session.createQuery(hql);
			topSpeed=query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}	
		return topSpeed;
	}
	public List<VehicleDTO> getVehicleNameByMileageGreaterThan(double mileage) {
		List<VehicleDTO>vehicleName=null;
		String hql="SELECT  vehicleName "
				+ "FROM VehicleDTO vehicle "
				+ "WHERE vehicle.mileage>:vmileage";
		try (Session session=factory.openSession()){
			Query query=session.createQuery(hql);
			query.setParameter("vmileage", mileage);
			vehicleName=query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}	
		return vehicleName;

	}
	public int deleteVehicleByName(String vehicleName) 
	{
		int noOfRecordsDeleted=0;
		Transaction tx=null;
		String hql="DELETE FROM VehicleDTO vehicle WHERE vehicle.vehicleName=:vname";
		try(Session session=factory.openSession();) {
			tx=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("vname", vehicleName);
			noOfRecordsDeleted=query.executeUpdate();
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return noOfRecordsDeleted;

	}
	
}

