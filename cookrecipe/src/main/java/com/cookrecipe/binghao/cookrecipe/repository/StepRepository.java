package com.cookrecipe.binghao.cookrecipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cookrecipe.binghao.cookrecipe.entity.Step;


/**
 * central place to store and maintain the data of steps.
 * @author Lim Bing Hao
 *
 */
@Repository
public interface StepRepository extends CrudRepository<Step, Integer> {

}
