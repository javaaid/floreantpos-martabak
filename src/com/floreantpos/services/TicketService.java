package com.floreantpos.services;

import com.floreantpos.POSConstants;
import com.floreantpos.PosException;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.dao.TicketDAO;

public class TicketService {
	public static Ticket getTicket(int ticketId) {
		TicketDAO dao = new TicketDAO();
		Ticket ticket = dao.get(Integer.valueOf(ticketId));

		if (ticket == null) {
			throw new PosException(POSConstants.NO_TICKET_WITH_ID + " " + ticketId + " " + POSConstants.FOUND);
		}
		
		return ticket;
	}
	
	public static void refundTicket(Ticket ticket) throws Exception {
		PosTransactionService service = PosTransactionService.getInstance();
		service.refundTicket(ticket);
		ticket.setDrawerResetted(false);
	}
}
