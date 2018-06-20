package idwall.desafio.string;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IdwallFormatterTest {
	
	private IdwallFormatter underTest;
	
	@Before
	public void init() {
		underTest = new IdwallFormatter();
	}
	
	@Test
	public void shouldJustifyIn2LinesWhenFormatting() {
		String formatted = underTest.format("This text should be formatted in at least two lines and justified.");
		
		assertEquals("This  text  should  be  formatted  in at\nleast    two    lines   and   justified.", formatted);
	}
	
	@Test
	public void shouldJustifyAndSeparatedIn2SentencesWhenFormatting() {
		String formatted = underTest.format("This text should be formatted in at least two lines and justified.\n\nAnd with two sentences.");
		
		assertEquals("This  text  should  be  formatted  in at\nleast    two    lines   and   justified.\n\nAnd       with       two      sentences.", formatted);
	}
	
	@Test
	public void shouldReturnEmptyStringWhenFormatting() {
		String formatted = underTest.format("");
		
		assertEquals("", formatted);
	}
	
	@Test
	public void shouldNotJustifyWhenFormatting() {
		underTest = new IdwallFormatter(40, false);
		String formatted = underTest.format("This text should be formatted in at least two lines and not justified.");
		
		assertEquals("This text should be formatted in at\nleast two lines and not justified.", formatted);
	}
	
	@Test
	public void q() {
		underTest = new IdwallFormatter(40, false);
		String formatted = underTest.format(null);
		
		assertEquals("This text should be formatted in at\nleast two lines and not justified.", formatted);
	}

}
