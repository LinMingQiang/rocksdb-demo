package com.git.rocksdb.demo.rocksdb_demo

import org.rocksdb.RocksDB
import org.rocksdb.Options
import org.rocksdb.CompressionType
import org.rocksdb.util.SizeUnit
import org.rocksdb.CompactionStyle
import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.concurrent.Await
import scala.concurrent.duration.Duration
/**
 * @author ${user.name}
 */
object App {

  val filep = "D:\\workspace\\code\\workspace-git\\rocksdb-demo\\storedir\\test.db"
  def main(args: Array[String]) {
    RocksDB.loadLibrary()
    val options = new Options()
      .setCreateIfMissing(true)
      .setWriteBufferSize(256 * SizeUnit.MB)
      .setMaxWriteBufferNumber(4)
      .setMaxBackgroundCompactions(16)
      .setCompactionStyle(CompactionStyle.UNIVERSAL)
    val db = RocksDB.open(options, filep)
    val f = db.put("k".getBytes, "ffff".getBytes)
    println(new String(db.get("k".getBytes)))
    //Thread.sleep(10000)
    db.close()
  }

}
