package com.primosoft.astman.core.ast.algorithm;

/**
 * Created on 20.09.16.
 *
 * @author atelizhenko
 */
public interface Algorithm<Result, Predicate> {

	Result invokeAlgorithm(Predicate predicate);
}
