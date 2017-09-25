package it.com.ibm.generali.CapitalReporting.service;

import it.com.ibm.generali.CapitalReporting.dto.ReportAvailabilityReqDTO;
import it.com.ibm.generali.CapitalReporting.dto.ReportAvailabilityRespDTO;
import org.springframework.stereotype.Service;

@Service
public class Availability
{
    public ReportAvailabilityRespDTO checkAvailable(ReportAvailabilityReqDTO request)
    {
        String message = request.getEnvironmentId() +
                " " + request.getReportId() + " > " +
                request.getReportFile();
        return new ReportAvailabilityRespDTO(true, message);
    }
}
