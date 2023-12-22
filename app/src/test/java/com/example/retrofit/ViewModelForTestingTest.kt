package com.example.retrofit

import junit.framework.Assert.failSame
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertSame
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test



class ViewModelForTestingTest{
    private lateinit var viewModel: ViewModelForTesting
    @Before
    fun setUp(){
        viewModel = ViewModelForTesting()
    }
    @Test
    fun `test if number value set correct`(){
        val number = "123"
        val result = viewModel.enterNumber(number)

        assertEquals("123", result)
    }

    @Test
    fun `test if number value is incorrect`(){
        val number = "123"
        val result = viewModel.enterNumber(number)
        assertNotEquals("124", result)
    }

    @Test
    fun `test if value clean correctly`(){
        val result = viewModel.enterNumber("1234")
        assertEquals("1234", result)
    }

    @Test
    fun `test if value is same`(){
        val result = viewModel.enterNumber("1234")
        assertSame("1234", result)
    }

    @Test
    fun `test if condition isn't null`(){
        val result = viewModel.enterNumber("1234")
        assertNotNull("1234", result)
    }

}