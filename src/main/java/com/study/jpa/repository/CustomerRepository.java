package com.study.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.study.jpa.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * Spring Data JPA也允许通过声明他们的识别标识自定义其他的查询方法， 比如下面这个findByLastName()方法
	 *
	 * @param lastName
	 *            名
	 */
	List<Customer> findByLastName(String lastName);

	/**
	 * 通过firstName查找
	 *
	 * @param firstName
	 *            firstName
	 */
	Customer findByFirstName(String firstName);

	/**
	 * 通过id查询对应记录
	 *
	 * @param id
	 *            主键id
	 */
	Optional<Customer> findById(long id);

	/**
	 * 根据lastName删除记录
	 *
	 * @param lastName
	 *            名
	 */
	@Transactional
	long deleteByLastName(String lastName);
}
