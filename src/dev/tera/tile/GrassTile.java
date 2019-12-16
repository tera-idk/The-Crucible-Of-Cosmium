package dev.tera.tile;

import dev.tera.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(final int id) {
		super(Assets.grassTile, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
