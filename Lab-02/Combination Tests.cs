using Lab_2;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace Lab_2_Test
{
    [TestClass]
    public class CombinationTests
    {
        Combination combination = new Combination();

        [TestMethod]
        public void Test_5C2()
        {
            Assert.AreEqual(10, combination.calculateCombination(5, 2));
        }
        [TestMethod]
        public void Test_12C10()
        {
            Assert.AreEqual(66, combination.calculateCombination(12, 10));
        }
        [TestMethod]
        public void Test_15C2()
        {
            Assert.AreEqual(105,combination.calculateCombination(15,2));    
        }
        [TestMethod]


       
        public void Test_6C6()
        {
            Assert.AreEqual(1, combination.calculateCombination(6, 6));
        }
        [TestMethod]
        public void Test_15C14()
        {
            Assert.AreEqual(15, combination.calculateCombination(15, 14));
        }
        [TestMethod]
        public void Test_3C0()
        {
            Assert.AreEqual(1, combination.calculateCombination(3, 0));
        }
        [TestMethod]
        public void Test_10C5()
        {
            Assert.AreEqual(45, combination.calculateCombination(10,5));
        }
        [TestMethod]
        public void Test_4C2()
        {
            Assert.AreEqual(6, combination.calculateCombination(4, 2));
        }
        public void Test_Range()
        {
            combination.calculateCombination(1000, 0);
        }


    }
}
