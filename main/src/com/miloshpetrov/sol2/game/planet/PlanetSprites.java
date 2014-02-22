package com.miloshpetrov.sol2.game.planet;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.miloshpetrov.sol2.common.SolMath;
import com.miloshpetrov.sol2.game.*;
import com.miloshpetrov.sol2.game.dra.Dra;
import com.miloshpetrov.sol2.game.dra.DraMan;

import java.util.List;

public class PlanetSprites implements SolObj {

  private final Planet myPlanet;
  private float myRelAngleToPlanet;
  private final float myDist;
  private final List<Dra> myDras;
  private final float myToPlanetRotSpd;
  private final Vector2 myPos;
  private final float myRadius;
  private float myAngle;

  public PlanetSprites(Planet planet, float relAngleToPlanet, float dist, List<Dra> dras, float toPlanetRotSpd) {
    myPlanet = planet;
    myRelAngleToPlanet = relAngleToPlanet;
    myDist = dist;
    myDras = dras;
    myToPlanetRotSpd = toPlanetRotSpd;
    myPos = new Vector2();
    myRadius = DraMan.radiusFromDras(myDras);
    setDependentParams();
  }

  @Override
  public void update(SolGame game) {
    setDependentParams();
    myRelAngleToPlanet += myToPlanetRotSpd * game.getTimeStep();
  }

  private void setDependentParams() {
    float angleToPlanet = myPlanet.getAngle() + myRelAngleToPlanet;
    SolMath.fromAl(myPos, angleToPlanet, myDist, true);
    myPos.add(myPlanet.getPos());
    myAngle = angleToPlanet + 90;
  }

  @Override
  public boolean shouldBeRemoved(SolGame game) {
    return false;
  }

  @Override
  public void onRemove(SolGame game) {
  }

  @Override
  public float getRadius() {
    return myRadius;
  }

  @Override
  public void receiveDmg(float dmg, SolGame game, Vector2 pos) {
  }

  @Override
  public boolean receivesGravity() {
    return false;
  }

  @Override
  public void receiveAcc(Vector2 acc, SolGame game) {
  }

  @Override
  public Vector2 getPos() {
    return myPos;
  }

  @Override
  public FarObj toFarObj() {
    return new FarPlanetSprites(myPlanet, myRelAngleToPlanet, myDist, myDras, myRadius, myToPlanetRotSpd);
  }

  @Override
  public List<Dra> getDras() {
    return myDras;
  }

  @Override
  public float getAngle() {
    return myAngle;
  }

  @Override
  public Vector2 getSpd() {
    return null;
  }

  @Override
  public void handleContact(SolObj other, Contact contact, ContactImpulse impulse, boolean isA, float absImpulse,
    SolGame game)
  {
  }

  @Override
  public String toDebugString() {
    return null;
  }

}