/**
 * 
 */
package com.medilab.preclinic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.medilab.preclinic.bean.DoctorBean;
import com.medilab.preclinic.model.Doctor;
import com.medilab.preclinic.repo.DoctorRepo;

/**
 * @author nsanda
 *
 */
@Service
public class MedilabDoctorServiceImpl implements MedilabDoctorService {

	@Autowired
	private DoctorRepo doctRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDoctorService#save(com.medilab.
	 * preclinic.bean.DoctorBean)
	 */
	@Override
	public DoctorBean save(DoctorBean doctBean) {
		Doctor doctModel = new Doctor();
		Address addrModel = new Address();
		BeanUtils.copyProperties(doctBean, addrModel);
		BeanUtils.copyProperties(doctBean, doctModel);
		
		
		doctRepo.save(doctModel);

		BeanUtils.copyProperties(doctModel, doctBean);
		
		BeanUtils.copyProperties(addrModel, doctBean);		

		return doctBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDoctorService#findAll()
	 */
	@Override
	public List<DoctorBean> findAll() {
		List<Doctor> doctModelList = doctRepo.findAll();
		List<DoctorBean> doctBeanList = new ArrayList<>();
		if (doctModelList != null && doctModelList.size() > 0) {
			doctModelList.stream().forEach(doctModel -> {
				DoctorBean doctBean = new DoctorBean();
				BeanUtils.copyProperties(doctModel, doctBean);
				doctBeanList.add(doctBean);
			});
		}
		return doctBeanList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDoctorService#findById(int)
	 */
	@Override
	public DoctorBean findById(int id) {
		Optional<Doctor> doctOpt = doctRepo.findById(id);
		DoctorBean doctBean = new DoctorBean();
		Doctor doctModel = doctOpt.get();
		BeanUtils.copyProperties(doctModel, doctBean);
				
		return doctBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDoctorService#findByName(java.lang.
	 * String)
	 */
	@Override
	public DoctorBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDoctorService#delete(int)
	 */
	@Override
	public List<DoctorBean> delete(int id) {
		doctRepo.deleteById(id);
		return findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDoctorService#delete(com.medilab.
	 * preclinic.bean.DoctorBean)
	 */
	@Override
	public List<DoctorBean> delete(DoctorBean deptBean) {
		Doctor Doctor = new Doctor();
		BeanUtils.copyProperties(deptBean, Doctor);
		doctRepo.delete(Doctor);
		return findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDoctorService#update(com.medilab.
	 * preclinic.bean.DoctorBean)
	 */
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,
	propagation=Propagation.REQUIRED)
	public DoctorBean update(DoctorBean doctBean) {
		
		Doctor doctModel = new Doctor();
		BeanUtils.copyProperties(doctBean, doctModel);
		doctRepo.save(doctModel);		
		BeanUtils.copyProperties(doctModel, doctBean);
		
		
		
		return doctBean;
	}

}
