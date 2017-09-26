package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dto.ReportAvailabilityReqDTO;
import it.com.ibm.generali.capitalreporting.dto.ReportAvailabilityRespDTO;
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
