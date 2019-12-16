package dev.tera.tile;

import dev.tera.gfx.Assets;

public class DirtTile extends Tile {

	public DirtTile(final int id) {
		super(Assets.dirtTile, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
