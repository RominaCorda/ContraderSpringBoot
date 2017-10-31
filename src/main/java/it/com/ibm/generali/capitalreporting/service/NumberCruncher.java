package it.com.ibm.generali.capitalreporting.service;

import org.springframework.stereotype.Service;

@Service
public class NumberCruncher implements INumberCruncher
{
    @Override
    public int square(int number)
    {
        return number * number;
    }
}
