/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
// Title: P1_Implement and Test DataStructureADT
// Files: DataStructureADTTest.java
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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the method that we wrote in the DataStructureADT interface and DS_my
 * class
 * 
 * @author Shiyu Zhu
 *
 * @param <T> A general type
 */
abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T dataStructureInstance;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
    dataStructureInstance = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    dataStructureInstance = null;
  }


  @Test
  void test00_empty_ds_size() {
    if (dataStructureInstance.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + dataStructureInstance.size());
  }


  /**
   * This method is going to test if the insert one key value pair into the data structure will
   * change the size to 1. If no fail occurs, it counts as a pass.
   */
  @Test
  void test01_after_insert_one_size_is_one() {
    // insert one key value pair into the data structure
    dataStructureInstance.insert("1", "CSHOO");
    // if the size not change to 1, fail occurs
    if (dataStructureInstance.size() != 1)
      fail("data structure should not be empty after insert one, with size=1, but size="
          + dataStructureInstance.size());
  }

  /**
   * This method is going to insert one key,value pair and remove it, and check whether the size
   * will still be 0. If no fail occurs, it counts as a pass.
   */
  @Test
  void test02_after_insert_one_remove_one_size_is_zero() {
    // insert one key value pair into the data structure
    dataStructureInstance.insert("1", "CSHOO");
    // remove one key value pair from the data structure
    dataStructureInstance.remove("1");
    // if size changed, fail occurs
    if (dataStructureInstance.size() != 0)
      fail("data structure should be empty after insert one and remove one, with size=0, but size="
          + dataStructureInstance.size());
  }

  /**
   * This method is going to test whether will the RuntimeException throw after inserting a few
   * key,value pairs such that one of them has the same key as an earlier one.If no fail occurs, it
   * counts as a pass.
   */
  @Test
  void test03_duplicate_exception_is_thrown() {
    assertThrows(RuntimeException.class, () -> {
      // insert a few key,value pairs such that one of them has the same key as an earlier one
      dataStructureInstance.insert("1", "CSHOO");
      dataStructureInstance.insert("2", "ABCDE");
      dataStructureInstance.insert("3", "EFGHI");
      dataStructureInstance.insert("3", "JKLMN");
      dataStructureInstance.insert("4", "OPQRS");
    });
  }

  /**
   * This method is going to insert some key,value pairs, then try removing a key that was not
   * inserted.The remove() should return false. If no fail occurs, it counts as a pass.
   */
  @Test
  void test04_remove_returns_false_when_key_not_present() {
    // insert three key value pairs into the data structure
    dataStructureInstance.insert("1", "CSHOO");
    dataStructureInstance.insert("2", "ABCDE");
    dataStructureInstance.insert("3", "EFGHI");
    if (dataStructureInstance.remove("4") == true)
      fail("data structure should unable to remove a key that was not found");
  }

  /**
   * This method is going to test if the size will change to 50, after inserting 50 key,value
   * pairs.If no fail occurs, it counts as a pass.
   */
  @Test
  void test05_insert_50() {
    // insert 50 key value pairs into the data structure
    for (int i = 0; i < 50; i++) {
      dataStructureInstance.insert(Integer.toString(i), Integer.toString(i));
    }
    if (dataStructureInstance.size() != 50)
      fail("data structure should have 50 items, but size = " + dataStructureInstance.size());
  }

  /**
   * This method is going to test if the size will change to 25, after inserting 50 key,value pairs
   * and remove 25 pairs. If no fail occurs, it counts as a pass.
   */
  @Test
  void test06_insert_50_remove_25() {
    // insert 50 key value pairs into the data structure
    for (int i = 0; i < 50; i++) {
      dataStructureInstance.insert(Integer.toString(i), Integer.toString(i));
    }
    // remove 50 key value pairs into the data structure
    for (int i = 0; i < 25; i++) {
      dataStructureInstance.remove(Integer.toString(i));
    }
    if (dataStructureInstance.size() != 25)
      fail("data structure should have 25 items, but size = " + dataStructureInstance.size());
  }

  /**
   * This method is going to test if the size will change, after inserting 500 key,value pairs and
   * remove 500 pairs. If no fail occurs, it counts as a pass.
   */
  @Test
  void test07_insert_500_remove_500() {
    // insert 500 key value pairs into the data structure
    for (int i = 0; i < 500; i++) {
      dataStructureInstance.insert(Integer.toString(i), Integer.toString(i));
    }
    // remove 500 key value pairs into the data structure
    for (int i = 0; i < 500; i++) {
      dataStructureInstance.remove(Integer.toString(i));
    }
    if (dataStructureInstance.size() != 0)
      fail("data structure should have 0 items, but size = " + dataStructureInstance.size());
  }

  /**
   * This method is going to test the contains() method.If no fail occurs, it counts as a pass.
   */
  @Test
  void test08_insert_contains() {
    // insert one key value pair into the data structure
    dataStructureInstance.insert("1", "CSHOO");
    if (dataStructureInstance.contains("1") == false)
      fail("data structure should containds the value which pairs to the specific key");
  }

  /**
   * This method is going to test the get() method by inserting two pairs and get the value with the
   * key not null.If no fail occurs, it counts as a pass.
   */
  @Test
  void test09_insert_get() {
    // insert two key value pair into the data structure
    dataStructureInstance.insert("1", "CSHOO");
    dataStructureInstance.insert("2", "ABCDE");
    if (!dataStructureInstance.get("1").equals("CSHOO"))
      fail("data structure should return the value pairs to the specific key, but the value it "
          + "return is " + dataStructureInstance.get("1"));
  }

  /**
   * This method is going to test the get() method with null key.If no fail occurs, it counts as a
   * pass.
   */
  @Test
  void test10_get_null() {
    assertThrows(IllegalArgumentException.class, () -> {
      // insert four key value pairs into the data structure
      dataStructureInstance.insert("1", "CSHOO");
      dataStructureInstance.insert("2", "ABCDE");
      dataStructureInstance.insert("3", "ABCDE");
      dataStructureInstance.insert("4", "EFGHI");
      dataStructureInstance.get(null);
    });
  }
}
