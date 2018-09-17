package com.hit.cost.query;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/17 18:40
 * <p>
 * Created By IDEA
 * ==========================
 */
public class Inquirer {
    private List<BooleanExpression> expressionList;

    public Inquirer(List<BooleanExpression> expressionList) {
        this.expressionList = expressionList;
    }
    public Inquirer() {
        this.expressionList = new ArrayList<BooleanExpression>();
    }

    /**
     * 添加查询条件到Query内的查询集合
     * @param expression
     * @return
     */
    public  Inquirer putExpression(BooleanExpression expression){
        expressionList.add(expression);
        return this;
    }
    public Predicate  buildQuery(){
        BooleanExpression booleanExpression = null;
        for (int i = 0;i<expressionList.size();i++
             ) {
            if ( i == 0){
                booleanExpression = expressionList.get(i);
            }
            else{
                booleanExpression = booleanExpression.and(
                        expressionList.get(i)
                );
            }
        }
        return  booleanExpression;
    }

    public  <T> List<T> iteratorToList(Iterable<T> iterable){
        List<T> temp  = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()){
            temp.add(iterator.next());
        }
        return temp;
    }

}
