/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
// Title: P1_Implement and Test DataStructureADT
// Files: DS_My.java
// Semester: Spring 2019
// Course: CS400
// Lecture: 002
// Due Date: Before 10pm on February 7, 2019
// Author: Shiyu Zhu
// Email: SZHU227@wisc.edu
// Lecture's Name: Deb Deppeler
// Bugs: no known bugs
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class implement our own data structure.
 * 
 * @author Shiyu Zhu
 *
 */
public class DS_My implements DataStructureADT {

  /**
   * This is an inner class for storing key and value as a pair.
   * 
   * @author Shiyu Zhu
   *
   */
  private class Paired_Data {
    private Comparable key;
    private Object value;

    /**
     * This is an inner class constructor which assign key to k,value to v.
     * 
     * @param k
     * @param v
     */
    private Paired_Data(Comparable k, Object v) {
      key = k;
      value = v;
    }

    /**
     * This is an inner class method which return the key.
     * 
     * @return
     */
    private Comparable getKey() {
      return key;
    }

    /**
     * This is an inner class method whcih return the value.
     * 
     * @return
     */
    private Object getValue() {
      return value;
    }
  }

  private Paired_Data MyPairs[];
  private int size;

  /**
   * This is a outer class constructor which initialize the size and array
   */
  public DS_My() {
    this.MyPairs = new Paired_Data[1000];
    this.size = 0;
  }

  /**
   * This is a outer class method to insert the key,value pair to the data structure and increases
   * size. If key is null, throws IllegalArgumentException("null key"); If key is already in data
   * structure, throws RuntimeException("duplicate key"); Can accept and insert null values.
   */
  @Override
  public void insert(Comparable k, Object v) {
    // If key is null, throws IllegalArgumentException("null key")
    if (k == null) {
      throw new IllegalArgumentException("null key");
    }
    // If key is already in data structure, throws RuntimeException("duplicate key");
    for (int i = 0; i < size; i++) {
      if (MyPairs[i].getKey().equals(k)) {
        throw new RuntimeException("duplicate key");
      }
    }
    // Add the key,value pair to the data structure and increases size.
    Paired_Data pairs = new Paired_Data(k, v);
    MyPairs[size] = pairs;
    this.size++;
  }

  /**
   * This is a outer class method to removes the key from the data structure and decreases size if
   * key is found.If key is null, throws IllegalArgumentException("null key") without decreasing
   * size.If key is not found, returns false.
   */
  @Override
  public boolean remove(Comparable k) {
    // If key is null, throws IllegalArgumentException("null key")
    if (k == null) {
      throw new IllegalArgumentException("null key");
    }
    // If key is found, Removes the key from the data structure and decreases size
    for (int i = 0; i < size; i++) {
      if (MyPairs[i].getKey().equals(k)) {
        for (int n = i; n < size; n++) {
          MyPairs[n] = MyPairs[n + 1];
        }
        MyPairs[size] = null;
        this.size--;
        return true;
      }
    }
    // If key is not found, returns false.
    return false;
  }

  /**
   * This is a outer class method to returns the value associated with the specified key.If key is
   * null, throws IllegalArgumentException("null key") without decreasing size.
   * 
   */
  @Override
  public boolean contains(Comparable k) {
    boolean checkContain = false;
    // Returns true if the key is in the data structure
    for (int i = 0; i < size; i++) {
      if (MyPairs[i].getKey().equals(k)) {
        checkContain = true;
      }
    }
    // Returns false if key is null or not present
    return checkContain;
  }

  /**
   * This is a outer class method to returns true if the key is in the data structure.Returns false
   * if key is null or not present
   */
  @Override
  public Object get(Comparable k) {
    Object valueAssociated = null;
    // If key is null, throws IllegalArgumentException("null key")
    if (k == null) {
      throw new IllegalArgumentException("null key");
    }
    // Returns the value associated with the specified key
    for (int i = 0; i < size; i++) {
      if (MyPairs[i].getKey().equals(k)) {
        valueAssociated = MyPairs[i].getValue();
      }
    }
    return valueAssociated;
  }

  /**
   * This is a outer class method which returns the number of elements in the data structure
   */
  @Override
  public int size() {
    return this.size;
  }

}
