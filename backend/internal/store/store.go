package store

type Factory interface {
	Disk() DiskStore
}
