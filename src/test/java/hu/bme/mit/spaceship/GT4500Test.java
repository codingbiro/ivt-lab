package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockTS1;
  private TorpedoStore mockTS2;

  @BeforeEach
  public void init(){
    this.mockTS1 = mock(TorpedoStore.class);
    this.mockTS2 = mock(TorpedoStore.class);
    this.ship = new GT4500(this.mockTS1, this.mockTS2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(this.mockTS1.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    // Verify
    verify(this.mockTS1, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(this.mockTS1.fire(1)).thenReturn(true);
    when(this.mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);

    // Verify
    verify(this.mockTS1, times(1)).fire(1);
    verify(this.mockTS2, times(1)).fire(1);
  }

}
