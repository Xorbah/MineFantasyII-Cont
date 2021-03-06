package minefantasy.mf2.mechanics.worldGen;

import java.util.HashMap;
import java.util.Random;

import minefantasy.mf2.util.MFLogUtil;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMFBase implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		generate(random, chunkX, chunkZ, world, world.provider.dimensionId);
	}
	public void generate(Random random, int chunkX, int chunkZ, World world, int dimension) 
	{
		WorldGenGeological.generate(random, chunkX, chunkZ, world, dimension);
		WorldGenBiological.generate(random, chunkX, chunkZ, world, dimension);
		WorldGenStructures.generate(random, chunkX, chunkZ, world, dimension);
	}
}
