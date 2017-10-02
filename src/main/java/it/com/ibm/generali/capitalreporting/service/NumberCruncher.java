package it.com.ibm.generali.capitalreporting.service;

import org.springframework.stereotype.Service;

@Service
public class NumberCruncher
{
    public int square(int number)
    {
        return number * number;
    }
}
