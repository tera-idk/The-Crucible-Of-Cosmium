package dev.tera.tile;

import dev.tera.gfx.Assets;

public class StoneTile extends Tile {

	public StoneTile(final int id) {
		super(Assets.stoneTile, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
