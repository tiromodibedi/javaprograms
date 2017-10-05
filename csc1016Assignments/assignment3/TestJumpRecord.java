/*********************************************************
*  Test Jump Record Program: test the JumpRecord class   *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 03-09-2017                                      *
*********************************************************/
public class TestJumpRecord{
  public static void main(String[] args) {

    /*  TEST ONE  */
    System.out.println("Test 1");
    JumpRecord jump_record1 = new JumpRecord();
    jump_record1.recordJump(12.7);
    jump_record1.recordJump(3.4);
    jump_record1.recordJump(12.7);
    if ( jump_record1.jumps() == 3
      && jump_record1.foulJumps() == 0
      && jump_record1.finished()
      && jump_record1.getLongest() == 1
      && !jump_record1.isFoulJump(1)
      && jump_record1.getLongest() == 1
      && jump_record1.getJumpDistance(2) == 3.4
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST TWO  */
    System.out.println("Test 2");
    JumpRecord jump_record2 = new JumpRecord();
    jump_record2.recordJump(1.3);
    jump_record2.recordJump(3.4);
    jump_record2.recordFoulJump();
    if (jump_record2.jumps() == 3
      && jump_record2.foulJumps() == 1
      && jump_record2.finished()
      && jump_record2.getLongest() == 2
      && !jump_record2.isFoulJump(1)
      && jump_record2.isFoulJump(3)
      && jump_record2.getLongest() == 2
      && jump_record2.getJumpDistance(1) == 1.3
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST THREE  */
    System.out.println("Test 3");
    JumpRecord jump_record3 = new JumpRecord();
    jump_record3.recordJump(6.5);
    jump_record3.recordFoulJump();
    if (jump_record3.jumps() == 2
      && jump_record3.foulJumps() == 1
      && !jump_record3.finished()
      && jump_record3.getLongest() == 1
      && !jump_record3.isFoulJump(1)
      && jump_record3.isFoulJump(2)
      && jump_record3.getLongest() == 1
      && jump_record3.getJumpDistance(1) == 6.5
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST FOUR  */
    System.out.println("Test 4");
    JumpRecord jump_record4 = new JumpRecord();
    jump_record4.recordFoulJump();
    if (jump_record4.jumps() == 1
      && jump_record4.foulJumps() == 1
      && !jump_record4.finished()
      && jump_record4.isFoulJump(1)
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST FIVE  */
    System.out.println("Test 5");
    JumpRecord jump_record5 = new JumpRecord();
    jump_record5.recordFoulJump();
    jump_record5.recordJump(6.5);
    jump_record5.recordFoulJump();
    if (jump_record5.jumps() == 3
      && jump_record5.foulJumps() == 2
      && jump_record5.finished()
      && jump_record5.getLongest() == 2
      && jump_record5.isFoulJump(1)
      && !jump_record5.isFoulJump(2)
      && jump_record5.getJumpDistance(2) == 6.5
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST SIX  */
    System.out.println("Test 6");
    JumpRecord jump_record6 = new JumpRecord();
    jump_record6.recordJump(9.8);
    if (jump_record6.jumps() == 1
      && jump_record6.foulJumps() == 0
      && !jump_record6.finished()
      && jump_record6.getLongest() == 1
      && !jump_record6.isFoulJump(1)
      && jump_record6.getLongest() == 1
      && jump_record6.getJumpDistance(1) == 9.8
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST SEVEN  */
    System.out.println("Test 7");
    JumpRecord jump_record7 = new JumpRecord();
    jump_record7.recordJump(0.7);
    jump_record7.recordJump(2.3);
    jump_record7.recordFoulJump();
    if (jump_record7.jumps() == 3
      && jump_record7.foulJumps() == 1
      && jump_record7.finished()
      && jump_record7.getLongest() == 2
      && !jump_record7.isFoulJump(1)
      && !jump_record7.isFoulJump(2)
      && jump_record7.getJumpDistance(1) == 0.7
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST EIGHT  */
    System.out.println("Test 8");
    JumpRecord jump_record8 = new JumpRecord();
    jump_record8.recordJump(8.1);
    jump_record8.recordFoulJump();
    jump_record8.recordJump(6.3);
    if (jump_record8.jumps() == 3
      && jump_record8.foulJumps() == 1
      && jump_record8.finished()
      && jump_record8.getLongest() == 1
      && !jump_record8.isFoulJump(1)
      && jump_record8.isFoulJump(2)
      && jump_record8.getLongest() == 1
      && jump_record8.getJumpDistance(3) == 6.3
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST NINE  */
    System.out.println("Test 9");
    JumpRecord jump_record9 = new JumpRecord();
    jump_record9.recordFoulJump();
    jump_record9.recordJump(7.4);
    jump_record9.recordJump(6.5);
    if (jump_record9.jumps() == 3
      && jump_record9.foulJumps() == 1
      && jump_record9.finished()
      && jump_record9.getLongest() == 2
      && jump_record9.isFoulJump(1)
      && !jump_record9.isFoulJump(2)
      && jump_record9.getLongest() == 2
      && jump_record9.getJumpDistance(3) == 6.5
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

    /*  TEST TEN  */
    System.out.println("Test 10");
    JumpRecord jump_record10 = new JumpRecord();
    jump_record10.recordFoulJump();
    jump_record10.recordFoulJump();
    jump_record10.recordJump(5.3);
    if (jump_record10.jumps() == 3
      && jump_record10.foulJumps() == 2
      && jump_record10.finished()
      && jump_record10.getLongest() == 3
      && jump_record10.isFoulJump(1)
      && jump_record10.isFoulJump(2)
      && jump_record10.getJumpDistance(3) == 5.3
      ) {
      System.out.println("pass");
    } else {
      System.out.println("Fail");
    }

  }
}
