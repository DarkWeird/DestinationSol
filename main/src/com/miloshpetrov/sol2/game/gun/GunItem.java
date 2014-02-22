package com.miloshpetrov.sol2.game.gun;

import com.miloshpetrov.sol2.game.item.SolItem;

public class GunItem implements SolItem {

  public final GunConfig config;
  public int ammo;
  public float reloadAwait;

  public GunItem(GunConfig config, int ammo, float reloadAwait) {
    this.config = config;
    this.ammo = ammo;
    this.reloadAwait = reloadAwait;
  }

  @Override
  public String getTexName() {
    return config.itemTexName;
  }

  @Override
  public String getDisplayName() {
    return config.displayName;
  }

  @Override
  public float getPrice() {
    return config.price;
  }

  @Override
  public String getDesc() {
    return config.desc;
  }

  @Override
  public GunItem copy() {
    return new GunItem(config, ammo, reloadAwait);
  }

  @Override
  public boolean isSame(SolItem item) {
    return item instanceof GunItem && ((GunItem) item).config == config;
  }

  public boolean canShoot() {
    return ammo > 0 || reloadAwait > 0;
  }

  public float getDps() {
    return config.dps;
  }
}